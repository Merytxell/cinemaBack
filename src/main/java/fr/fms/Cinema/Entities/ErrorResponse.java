package fr.fms.Cinema.Entities;

import java.util.List;
import lombok.Data;

@Data
public class ErrorResponse {

        private String message;
        private List<String> details;

        public ErrorResponse(String message, List<String> details) {
            this.message = message;
            this.details = details;
        }
    }
