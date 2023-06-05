package edu.miu.postbackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate Date;
    private LocalTime Time;
    public   String Principle ;
    public  String Operation;

    public Logger( LocalDate date, LocalTime time, String operation) {

        Date = date;
        Time = time;

        Operation = operation;
    }
}
