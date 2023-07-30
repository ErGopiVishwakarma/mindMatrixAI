package com.tgt.entity;

import java.util.List;

import com.tgt.model.Recommendation;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Integer userId;
	@ElementCollection
	private List<Integer> conversationsId;
	private Double score;
	@Enumerated
	private Recommendation recommendation;
}
