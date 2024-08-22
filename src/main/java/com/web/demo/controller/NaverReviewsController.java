/**
 *  클라이언트에게 네이버 영화 리뷰 데이터를 게시판형태로 제공
 */

package com.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.demo.entity.NaverReviews;
import com.web.demo.service.NaverReviewsService;

@RequestMapping("/bbs")
@Controller
public class NaverReviewsController {
	@Autowired
	private NaverReviewsService naverReviewsService;
	// 생성자 방식으로 해도 상관없음 현재는...
	
	// ~/bbs/list?page=1 이런 방식으로 호출
	@GetMapping("/list")
	public String list(Model model,
			@RequestParam(value="page", defaultValue = "0") int page ) {
		//1. 특정 페이지(인자)에 해당되는 페이징 데이터 획득
		Page<NaverReviews> paging = this.naverReviewsService.getList(page);
		// 리턴 타입 Page<NaverReviews>
		//2. html에 전달
		model.addAttribute("paging",paging);
		return "naver_reviews_list";
	}
	
	// 검색어 획득, 검색 작업 실제 진행(서비스- 레퍼지토리 처리), 전달내용(검색어, 페이징번호)
	@GetMapping("/list2")
	public String list2(Model model,
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="keyword", defaultValue = "") String keyword) {
		//1. 특정 페이지(인자)에 해당되는 페이징 데이터 획득
		Page<NaverReviews> paging = this.naverReviewsService.getList2(page, keyword);
		// 리턴 타입 Page<NaverReviews>
		//2. html에 전달
		model.addAttribute("keyword",keyword);
		model.addAttribute("paging",paging);
		return "naver_reviews_list";
	}
}


