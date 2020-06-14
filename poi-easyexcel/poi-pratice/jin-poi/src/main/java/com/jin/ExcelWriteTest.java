package com.jin;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest {
    private final static String FILE_PATH = "F:\\myworkspace\\poi-easyexcel\\poi-pratice\\jin-poi\\";

    @Test
    public void testWrite03() throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("狂神的粉丝表");

        Row row0 = sheet.createRow(0);
        Cell cell_1_1 = row0.createCell(0);
        cell_1_1.setCellValue("今日新增观众");
        Cell cell_1_2 = row0.createCell(1);
        cell_1_2.setCellValue("666");

        Row row1 = sheet.createRow(1);
        Cell cell_2_1 = row1.createCell(0);
        cell_2_1.setCellValue("统计时间");
        Cell cell_2_2 = row1.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell_2_2.setCellValue(s);

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + "jin03.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("jin03.xls文件生成完毕");

    }

    @Test
    public void testWrite07() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("狂神的粉丝表");

        Row row0 = sheet.createRow(0);
        Cell cell_1_1 = row0.createCell(0);
        cell_1_1.setCellValue("今日新增观众");
        Cell cell_1_2 = row0.createCell(1);
        cell_1_2.setCellValue("666");

        Row row1 = sheet.createRow(1);
        Cell cell_2_1 = row1.createCell(0);
        cell_2_1.setCellValue("统计时间");
        Cell cell_2_2 = row1.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell_2_2.setCellValue(s);

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + "jin07.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("jin07.xls文件生成完毕");

    }

    @Test
    public void testWriteBigData03() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("bigdata03");
        for (int i = 0; i < 65536; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + "bigdata03.xls");
        workbook.write(fileOutputStream);
        long end = System.currentTimeMillis();
        System.out.println("bigdata03.xls文件已生成,时间为=" + ((double) end - start) / 1000);
    }

    @Test
    public void testWriteBigData07() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("bigdata07");
        for (int i = 0; i < 100000; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + "bigdata07.xlsx");
        workbook.write(fileOutputStream);
        long end = System.currentTimeMillis();
        System.out.println("bigdata07.xls文件已生成,时间为=" + ((double) end - start) / 1000);
    }

    @Test
    public void testWriteBigData07S() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet("bigdataS07");
        for (int i = 0; i < 100000; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + "bigdataS07.xlsx");
        workbook.write(fileOutputStream);
        ((SXSSFWorkbook) workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println("bigdataS07.xls文件已生成,时间为=" + ((double) end - start) / 1000);
    }

    @Test
    public void testReadjin03() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH + "jin03.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        fileInputStream.close();
    }

    @Test
    public void testReadjbigdataS07() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH + "bigdataS07.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        //标题
//        Row rowTitle = sheet.getRow(0);
//        if (rowTitle!=null){
//            int physicalNumberOfCells = rowTitle.getPhysicalNumberOfCells();
//            for (int i = 0; i < physicalNumberOfCells; i++) {
//                Cell cell = rowTitle.getCell(i);
//                if (cell!=null){
//                    String stringCellValue = cell.getStringCellValue();
//                }
//            }
//        }

        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < physicalNumberOfRows; i++) {
            Row rowText = sheet.getRow(i);
            if (rowText != null) {
                int physicalNumberOfCells = rowText.getPhysicalNumberOfCells();
                for (int j = 0; j < physicalNumberOfCells; j++) {
                    Cell cell = rowText.getCell(j);
                    int cellType = cell.getCellType();
                    String cellVal = "";
                    switch (cellType) {
                        case HSSFCell.CELL_TYPE_STRING:
                            cellVal = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            cellVal = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            cellVal = "";
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                cellVal = new DateTime(cell.getDateCellValue()).toString("yyyy-MM-dd");
                            } else {
                                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                cellVal = cell.toString();
                            }
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            System.out.println("cell的类型错误");
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            String cellFormula = cell.getCellFormula();
                            FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
                            System.out.println(formulaEvaluator.evaluate(cell).formatAsString());
                            break;
                    }
                    System.out.println(cellVal);
                }
            }
        }
        fileInputStream.close();
    }
}
