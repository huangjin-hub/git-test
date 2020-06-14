package com.jin.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Dept implements Serializable {
    @Id
    private Long deptno;

    private String dname;

    @Column(name = "db_source")
    private String dbSource;

    private static final long serialVersionUID = 1L;

    /**
     * @return deptno
     */
    public Long getDeptno() {
        return deptno;
    }

    /**
     * @param deptno
     */
    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    /**
     * @return dname
     */
    public String getDname() {
        return dname;
    }

    /**
     * @param dname
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * @return db_source
     */
    public String getDbSource() {
        return dbSource;
    }

    /**
     * @param dbSource
     */
    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}