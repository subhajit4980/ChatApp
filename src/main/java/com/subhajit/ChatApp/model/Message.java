package com.subhajit.ChatApp.model;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    private String sender;
    private String content;
    private String timestamp;
}
