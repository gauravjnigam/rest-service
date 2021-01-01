package com.gn.restsvc.GnRestSvc.user.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
	private String message;
	private LocalDateTime timeStamp;
	private String details;
	
	
}
