package com.hcl.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
	private String message;
	private int errorCode;
}