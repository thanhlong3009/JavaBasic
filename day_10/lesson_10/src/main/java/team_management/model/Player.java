package team_management.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Player {
    private int number;
    private String name;
    private Position position;
}
