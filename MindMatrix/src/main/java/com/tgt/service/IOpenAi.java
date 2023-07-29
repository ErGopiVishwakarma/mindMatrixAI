package com.tgt.service;

import java.util.concurrent.CompletableFuture;

public interface IOpenAi {
	CompletableFuture<String> generate(String promptInput);
}
