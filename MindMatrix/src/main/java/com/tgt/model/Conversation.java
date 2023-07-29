package com.tgt.model;

import jakarta.persistence.Entity;
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
public class Conversation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer conversationId;
	private String conversation;
	
//	let userArayy =   [hello my nae is akhtar,what ca upi do ,,,,,,]
//	ley bot array = [hi akhtar how are upi , erply , ]
	
	
}
