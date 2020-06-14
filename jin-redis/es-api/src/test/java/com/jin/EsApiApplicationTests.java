package com.jin;

import com.alibaba.fastjson.JSON;
import com.jin.pojo.User;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
class EsApiApplicationTests {

	@Autowired
	private RestHighLevelClient client;

	@Test
	void testCreateIndex() throws IOException {
		CreateIndexRequest request = new CreateIndexRequest("kuang_index");
		CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
		System.out.println("----"+createIndexResponse);

	}

	@Test
	void testExistIndex() throws IOException {
		GetIndexRequest kuang_index = new GetIndexRequest("kuang_index");
		boolean exists = client.indices().exists(kuang_index, RequestOptions.DEFAULT);
		System.out.println(exists);
	}
	@Test
	void  testDeleteIndex() throws IOException {
		DeleteIndexRequest deleteIndexRequest=new DeleteIndexRequest("kuang_index");
		client.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
	}

	@Test
	void testAddDocument() throws IOException {
		User user = new User("狂神说", 19);
		IndexRequest request = new IndexRequest("kuang_index");
		request.id("1");
		request.timeout(TimeValue.timeValueSeconds(1));
		request.source(JSON.toJSONString(user),XContentType.JSON);
		IndexResponse index = client.index(request, RequestOptions.DEFAULT);
		System.out.println(index.toString());
		System.out.println(index.status());
	}

	@Test
	void testExistUser() throws IOException {
		GetRequest request = new GetRequest("kuang_index", "1");
		request.fetchSourceContext(new FetchSourceContext(false));
		request.storedFields("_none_");
		boolean exists = client.exists(request, RequestOptions.DEFAULT);
		System.out.println(exists);
	}

	@Test
	void getDocument() throws IOException {
		GetRequest request = new GetRequest("kuang_index", "1");
		GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
		System.out.println(getResponse.getSourceAsString());
	}

	@Test
	void updateDocument() throws IOException {
		UpdateRequest updateRequest = new UpdateRequest("kuang_index","1");
		User user = new User("狂神说java", 30);
		updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
		client.update(updateRequest, RequestOptions.DEFAULT);
	}
	@Test
	void deleteDocument() throws IOException {
		DeleteRequest deleteRequest = new DeleteRequest("kuang_index", "1");
		DeleteResponse delete = client.delete(deleteRequest, RequestOptions.DEFAULT);
		System.out.println(delete.status());
	}

	@Test
	void addUsers() throws IOException {
		BulkRequest bulkRequest = new BulkRequest();
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("jack", 1));
		users.add(new User("marry", 2));
		users.add(new User("jon", 3));
		users.add(new User("bob", 4));
		users.add(new User("steven", 5));
		users.add(new User("kaliy", 6));
		for (int i = 0; i < users.size(); i++) {
			bulkRequest.add(new IndexRequest("kuang_index").id(""+(i+1)).source(JSON.toJSONString(users.get(i)), XContentType.JSON));
		}
		BulkResponse index = client.bulk(bulkRequest, RequestOptions.DEFAULT);
		System.out.println(index.status());
	}

	@Test
	void searchDocument() throws IOException {
		SearchRequest searchRequest = new SearchRequest("kuang_index");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		//精确匹配
		//TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "jack");
		MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
		//searchSourceBuilder.query(termQueryBuilder);
		searchSourceBuilder.query(matchAllQueryBuilder);
		searchRequest.source(searchSourceBuilder);
		SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
		SearchHits hits = search.getHits();
		for (SearchHit hit : hits.getHits()) {
			System.out.println(hit.getSourceAsMap());
		}
	}
}
