package com.practice.multiapi;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlaceService {

    // private final RestTemplate restTemplate;

    private String jsonInString = "";

    private String orderApiUrl = "http://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1";

    private final String BASE_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService";
    private final String apiUri = "/areaBasedList";
    private final String serviceKey = "?ServiceKey=QK7JOuBN8P3kQEM6bd/JDpppKTaLEo+pvtYyNNK+L9mXXiVDC2TpJx9Pb2i6TJV0fP4beqfww4cvdZ6w0kK9sw==";
    private final String defaultQueryParam = "&MobileOS=ETC&MobileApp=AppTest&_type=json";
    private final String numOfRows = "&numOfRows=10";
    private final String pageNo = "&pageNo=1";

    // public PlaceService(RestTemplateBuilder restTemplateBuilder) {
    // this.restTemplate = restTemplateBuilder.build();
    // }

    public List<PlaceDto> getPlace() throws URISyntaxException, ParseException, UnsupportedEncodingException {

        // try {
        // HttpComponentsClientHttpRequestFactory factory = new
        // HttpComponentsClientHttpRequestFactory();
        // factory.setConnectTimeout(5000); // 타임아웃 설정 5초
        // factory.setReadTimeout(5000); // 타임아웃 설정 5초

        // 상세정보를 알기 위해서 ResponseEntity를 받는 것을 추천
        RestTemplate restTemplate = new RestTemplate();

        // UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(orderApiUrl)
        // .queryParam("numOfRows", "10")
        // .queryParam("pageNo", "1")
        // .queryParam("MobileOS", "ETC")
        // .queryParam("MobileApp", "AppTest")
        // .queryParam("arrange", "A")
        // .queryParam("_type", "json")
        // .queryParam("serviceKey ",
        // URLDecoder.decode(serviceKey, "UTF-8"));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        log.info("request: {}", httpEntity);

        // URI uri = new URI(builder.toUriString());
        String jsonString = restTemplate.getForObject(orderApiUrl +
                serviceKey +
                defaultQueryParam +
                numOfRows +
                pageNo, String.class);
        // String jsonString = restTemplate.getForObject(builder.toString(),
        // String.class);

        System.out.println(
                "|||||||||||||||| uri ||||||||||||||" + orderApiUrl +
                        serviceKey +
                        defaultQueryParam +
                        numOfRows +
                        pageNo);

        System.out.println(
                "|||||||||||||||| jsonString ||||||||||||||" + jsonString + URLDecoder.decode(serviceKey, "UTF-8"));

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);

        // 가장 큰 JSON 객체 response 가져오기
        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

        // 그 다음 body 부분 파싱
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

        // 그 다음 위치 정보를 배열로 담은 items 파싱
        JSONObject jsonItems = (JSONObject) jsonBody.get("items");

        // items는 JSON임, 이제 그걸 또 배열로 가져온다
        JSONArray jsonItemList = (JSONArray) jsonItems.get("item");

        List<PlaceDto> result = new ArrayList<>();

        for (Object o : jsonItemList) {
            JSONObject item = (JSONObject) o;
            result.add(makeLocationDto(item));
        }

        // ResponseEntity<PlaceDto> response = restTemplate.exchange(
        // builder.toUriString(),
        // HttpMethod.GET,
        // httpEntity,
        // PlaceDto.class);

        // ResponseEntity<List<PlaceDto>> response =
        // restTemplate.exchange(builder.toUriString(),
        // HttpMethod.GET,
        // httpEntity,
        // new ParameterizedTypeReference<List<PlaceDto>>() {
        // });

        // 데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
        // ObjectMapper mapper = new ObjectMapper();
        // jsonInString = mapper.writeValueAsString(response.getBody());

        // 에러 처리
        // if (response.getStatusCode() == HttpStatus.BAD_REQUEST
        // || response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
        // System.out.println(">>>>>> 에러 발생 >>>>>>>");
        // }

        // List<PlaceDto> list = response.getBody();
        // return list;

        // } catch (HttpClientErrorException | HttpServerErrorException e) {
        // System.out.println(e.toString());

        // } catch (Exception e) {
        // System.out.println(e.toString());
        // }

        return result;
    }

    // 콘텐츠 정보 JSON을 DTO로 변환
    private PlaceDto makeLocationDto(JSONObject item) {
        PlaceDto dto = PlaceDto.builder()
                .galContentId((String) item.get("galContentId"))
                .galContentTypeId((String) item.get("galContentTypeId"))
                .galTitle((String) item.get("galTitle"))
                .galWebImageUrl((String) item.get("galWebImageUrl"))
                .galPhotographyMonth((String) item.get("galPhotographyMonth"))
                .galPhotographyLocation((String) item.get("galPhotographyLocation"))
                .galPhotographer((String) item.get("galPhotographer"))
                .galSearchKeyword((String) item.get("galSearchKeyword"))
                .galCreatedtime((String) item.get("galCreatedtime"))
                .galModifiedtime((String) item.get("galModifiedtime"))
                .build();
        return dto;
    }

}
