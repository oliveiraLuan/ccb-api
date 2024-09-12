package com.luandeoliveira.ccb_api.controllers.exceptions;

import java.time.Instant;

public record StandardError(Instant timestamp, String path, String message, String error, String status) {
}
