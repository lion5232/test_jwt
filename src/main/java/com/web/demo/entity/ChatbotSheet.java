/**
 *  챗봇 시트 (질문에 대한 대답 메뉴얼 데이터)
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
public class ChatbotSheet {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator6")
    @SequenceGenerator(name = "sequence_generator6", sequenceName = "sequence_name6", allocationSize = 1)
	private long id;
	
	@Column(length =2048)
	private String question;
	
	@Column(length = 2048)
	private String answer;
	
	private Integer label;
}
