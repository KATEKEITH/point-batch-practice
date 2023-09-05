package com.practice.multiapi;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestClientTest(value = { PlaceService.class })
public class PlaceServiceTest {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private MockRestServiceServer mockServer;

    @Autowired
    private ObjectMapper objectMapper;

    private String orderApiUrl = "https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?";

    // ClientAndServer 객체를 이용해서 mockServer를 킵니다
    // MockServerClient 객체에서 목킹할 요청과 응답을 설정합니다
    @BeforeEach
    void setUp() {
        // mockServer = ClientAndServer.startClientAndServer(8888);
        // new MockServerClient("localhost", 8888)
        // .when(
        // request()
        // .withMethod("GET")
        // .withPath("/rss"))
        // .respond(
        // response()
        // .withHeader(new Header("Content-Type", "text/xml;charset=utf-8"))
        // .withBody(RSS_FEED_RESPONSE));
    }

    // ClientAndServer 객체를 이용해서 mockServer를 끕니다
    @AfterEach
    void shutDown() {
        // mockServer.stop();
    }

    @DisplayName("apiUserGetTest")
    @Test
    void getUserInfoTest()
            throws JsonProcessingException, ParseException, UnsupportedEncodingException, URISyntaxException {
        // given
        // String expectedServiceKey =
        // "QK7JOuBN8P3kQEM6bd%2FJDpppKTaLEo%2BpvtYyNNK%2BL9mXXiVDC2TpJx9Pb2i6TJV0fP4beqfww4cvdZ6w0kK9sw%3D%3D";
        // String expectedNumOfRows = "1";
        // String expectedPageNo = "1";
        // String expectedMobileOS = "ETC";
        // String expectedMobileApp = "AppTest";
        // String expectedArrange = "A";
        // String expectedType = "json";

        String expectedGalContentId = "3001509";
        String expectedGalContentTypeId = "17";
        String expectedGalTitle = "파주 프로방스마을";
        String expectedGalWebImageUrl = "http://tong.visitkorea.or.kr/cms2/website/09/3001509.jpg";
        String expectedGalPhotographyMonth = "202306";
        String expectedGalPhotographyLocation = "경기도 파주시 탄현면";
        String expectedGalPhotographer = "한국관광공사 송재근";
        String expectedGalSearchKeyword = "파주 프로방스마을, 경기도 파주시, 테마마을, 테마파크";
        String expectedGalCreatedtime = "20230828104738";
        String expectedGalModifiedtime = "20230828104759";

        String expectedApiUrl = orderApiUrl + "&"
                + "QK7JOuBN8P3kQEM6bd%2FJDpppKTaLEo%2BpvtYyNNK%2BL9mXXiVDC2TpJx9Pb2i6TJV0fP4beqfww4cvdZ6w0kK9sw%3D%3D"
                + "&" + "1" + "&"
                + "1" + "&" + "ETC" + "&" + "AppTest" + "&" + "A" + "&"
                + "json";

        String expectResult = objectMapper
                .writeValueAsString(new ExpectPlaceDto("3001509", "17", "파주 프로방스마을",
                        "http://tong.visitkorea.or.kr/cms2/website/09/3001509.jpg",
                        "202306", "경기도 파주시 탄현면", "한국관광공사 송재근", "파주 프로방스마을, 경기도 파주시, 테마마을, 테마파크",
                        "20230828104738", "20230828104759"));

        mockServer
                .expect(requestTo(expectedApiUrl))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(expectResult, MediaType.APPLICATION_JSON));

        // when
        List<PlaceDto> placeDto = placeService.getPlace();

        // then
        // assertEquals(placeDto.getGalContentId(), expectedGalContentId);
        // assertEquals(placeDto.getGalContentTypeId(), expectedGalContentTypeId);
        // assertEquals(placeDto.getGalTitle(), expectedGalTitle);
        // assertEquals(placeDto.getGalWebImageUrl(), expectedGalWebImageUrl);
        // assertEquals(placeDto.getGalPhotographer(), expectedGalPhotographer);
        // assertEquals(placeDto.getGalPhotographyLocation(),
        // expectedGalPhotographyLocation);
        // assertEquals(placeDto.getGalPhotographyMonth(), expectedGalPhotographyMonth);
        // assertEquals(placeDto.getGalSearchKeyword(), expectedGalSearchKeyword);
        // assertEquals(placeDto.getGalCreatedtime(), expectedGalCreatedtime);
        // assertEquals(placeDto.getGalModifiedtime(), expectedGalModifiedtime);

        // assertAll(
        // () -> assertThat(placeDto.getGalContentId()).isEqualTo("1"),

        // () -> assertThat(entries.get(0).getTitle()).isEqualTo(POST_ONE_TITLE),
        // () -> assertThat(entries.get(0).getLink()).isEqualTo(POST_ONE_LINK),

        // () -> assertThat(entries.get(1).getTitle()).isEqualTo(POST_TWO_TITLE),
        // () -> assertThat(entries.get(1).getLink()).isEqualTo(POST_TWO_LINK));
    }

    static class ExpectPlaceDto {

        private String galContentId;

        private String galContentTypeId;

        private String galTitle;

        private String galWebImageUrl;

        private String galPhotographyMonth;

        private String galPhotographyLocation;

        private String galPhotographer;

        private String galSearchKeyword;

        private String galCreatedtime;

        private String galModifiedtime;

        ExpectPlaceDto() {
        }

        ExpectPlaceDto(String galContentId, String galContentTypeId, String galTitle, String galWebImageUrl,
                String galPhotographyMonth, String galPhotographyLocation, String galPhotographer,
                String galSearchKeyword, String galCreatedtime, String galModifiedtime) {

            this.galContentId = galContentId;
            this.galContentTypeId = galContentTypeId;
            this.galTitle = galTitle;
            this.galWebImageUrl = galWebImageUrl;
            this.galPhotographyMonth = galPhotographyMonth;
            this.galPhotographyLocation = galPhotographyLocation;
            this.galPhotographer = galPhotographer;
            this.galSearchKeyword = galSearchKeyword;
            this.galCreatedtime = galCreatedtime;
            this.galModifiedtime = galModifiedtime;
        }

        String getGalContentId() {
            return galContentId;
        }

        String getGalContentTypeId() {
            return galContentTypeId;
        }

        String getGalTitle() {
            return galTitle;
        }

        String getGalWebImageUrl() {
            return galWebImageUrl;
        }

        String getGalPhotographyMonth() {
            return galPhotographyMonth;
        }

        String getGalPhotographyLocation() {
            return galPhotographyLocation;
        }

        String getGalPhotographer() {
            return galPhotographer;
        }

        String getGalSearchKeyword() {
            return galSearchKeyword;
        }

        String getGalCreatedtime() {
            return galCreatedtime;
        }

        String getGalModifiedtime() {
            return galModifiedtime;
        }
    }

}
