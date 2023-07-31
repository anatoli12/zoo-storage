package com.tinqin.storage.api.base;
public interface Processor<Request extends ProcessorInput, Response extends ProcessorOutput> {
    Response process(Request input);
}