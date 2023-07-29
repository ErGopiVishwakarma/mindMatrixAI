package com.tgt.model;

import java.util.List;

import com.tgt.controller.Recommendation;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chatId;
	private String industrieType;
	private String jobRole;
	private String diffculityLevel;
	private String interviewMode;
	@OneToMany
	private List<Conversation> conversations;
	private Double score;
	@Enumerated
	private Recommendation recommendation;
}
