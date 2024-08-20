/**
 *  네이버 영화 리뷰 데이터를 담는 테이블과 연관된 데이터
 */

package com.web.demo.entity;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@ToString
public class NaverReviews {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator5")
    @SequenceGenerator(name = "sequence_generator5", sequenceName = "sequence_name5", allocationSize = 1)
	private long id;
	
	@Column(length = 2048)
	private String document;
	
	private Integer label;
}
