package com.productshut.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TimeSlot_TBL")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timeSlotId")
    private int timeSlotId;

    @Column(name = "morning")
    private boolean morning;

    @Column(name = "afternoon")
    private boolean afternoon;

    @Column(name = "evening")
    private boolean evening;

    @Column(name = "date")
    private Date date;
}
