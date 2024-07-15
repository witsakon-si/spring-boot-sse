package com.sse.controller;

import com.sse.service.EmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    public static final String TOKEN = "token";

    private final EmitterService emitterService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribeEvent(@RequestParam(value = TOKEN) String token) {
        log.debug("subscribeEvent {}", token);
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        emitterService.addEmitter(emitter);
        return emitter;
    }
}
