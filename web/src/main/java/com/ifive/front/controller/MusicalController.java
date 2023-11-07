package com.ifive.front.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifive.front.entity.Musical;
import com.ifive.front.service.MusicalService;

// 뮤지컬 데이터 컨트롤러


@Controller
public class MusicalController {
    private final Logger log = LoggerFactory.getLogger(MusicalController.class);

    @Autowired
    private MusicalService musicalService;

    // 임시 목데이터
    public String jsonStr = "[" +
        "  {" +
        "    \"goodsCode\": \"223112\"," +
        "    \"goodsName\": \"삼총사\"," +
        "    \"placeCode\": \"서울\"," +
        "    \"placeName\": \"NewPlaceName1\"," +
        "    \"genreCode\": \"NewGenreCode1\"," +
        "    \"genreName\": \"NewGenreName1\"," +
        "    \"genreSubCode\": \"NewGenreSubCode1\"," +
        "    \"genreSubName\": \"NewGenreSubName1\"," +
        "    \"viewRateCode\": \"NewViewRateCode1\"," +
        "    \"viewRateName\": \"NewViewRateName1\"," +
        "    \"runningTime\": \"NewRunningTime1\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"223113\"," +
        "    \"goodsName\": \"The Moon - 경주\"," +
        "    \"placeCode\": \"NewPlaceCode2\"," +
        "    \"placeName\": \"NewPlaceName2\"," +
        "    \"genreCode\": \"NewGenreCode2\"," +
        "    \"genreName\": \"NewGenreName2\"," +
        "    \"genreSubCode\": \"NewGenreSubCode2\"," +
        "    \"genreSubName\": \"NewGenreSubName2\"," +
        "    \"viewRateCode\": \"NewViewRateCode2\"," +
        "    \"viewRateName\": \"NewViewRateName2\"," +
        "    \"runningTime\": \"NewRunningTime2\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode3\"," +
        "    \"goodsName\": \"NewGoodsName3\"," +
        "    \"placeCode\": \"NewPlaceCode3\"," +
        "    \"placeName\": \"NewPlaceName3\"," +
        "    \"genreCode\": \"NewGenreCode3\"," +
        "    \"genreName\": \"NewGenreName3\"," +
        "    \"genreSubCode\": \"NewGenreSubCode3\"," +
        "    \"genreSubName\": \"NewGenreSubName3\"," +
        "    \"viewRateCode\": \"NewViewRateCode3\"," +
        "    \"viewRateName\": \"NewViewRateName3\"," +
        "    \"runningTime\": \"NewRunningTime3\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode4\"," +
        "    \"goodsName\": \"NewGoodsName4\"," +
        "    \"placeCode\": \"NewPlaceCode4\"," +
        "    \"placeName\": \"NewPlaceName4\"," +
        "    \"genreCode\": \"NewGenreCode4\"," +
        "    \"genreName\": \"NewGenreName4\"," +
        "    \"genreSubCode\": \"NewGenreSubCode4\"," +
        "    \"genreSubName\": \"NewGenreSubName4\"," +
        "    \"viewRateCode\": \"NewViewRateCode4\"," +
        "    \"viewRateName\": \"NewViewRateName4\"," +
        "    \"runningTime\": \"NewRunningTime4\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode5\"," +
        "    \"goodsName\": \"NewGoodsName5\"," +
        "    \"placeCode\": \"NewPlaceCode5\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode6\"," +
        "    \"goodsName\": \"NewGoodsName6\"," +
        "    \"placeCode\": \"NewPlaceCode5\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode7\"," +
        "    \"goodsName\": \"NewGoodsName7\"," +
        "    \"placeCode\": \"NewPlaceCode7\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode8\"," +
        "    \"goodsName\": \"NewGoodsName8\"," +
        "    \"placeCode\": \"NewPlaceCode8\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode123\"," +
        "    \"goodsName\": \"NewGoodsName123\"," +
        "    \"placeCode\": \"NewPlaceCode123\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }," +
        "  {" +
        "    \"goodsCode\": \"NewGoodsCode44\"," +
        "    \"goodsName\": \"NewGoodsName445\"," +
        "    \"placeCode\": \"NewPlaceCode445\"," +
        "    \"placeName\": \"NewPlaceName5\"," +
        "    \"genreCode\": \"NewGenreCode5\"," +
        "    \"genreName\": \"NewGenreName5\"," +
        "    \"genreSubCode\": \"NewGenreSubCode5\"," +
        "    \"genreSubName\": \"NewGenreSubName5\"," +
        "    \"viewRateCode\": \"NewViewRateCode5\"," +
        "    \"viewRateName\": \"NewViewRateName5\"," +
        "    \"runningTime\": \"NewRunningTime5\"" +
        "  }" +
        "]";


    @GetMapping("/list/{userName}")
    public String drawMusicalList(@PathVariable String userName, Model model) {
        List<Musical> musicalList = musicalService.getMusicalList(jsonStr);
        
        model.addAttribute("musicalList", musicalList);
        model.addAttribute("userName", userName);

        log.info("User {} requested musical list with {} items.", userName, musicalList.size());

        return "basic/list";
    }
}
