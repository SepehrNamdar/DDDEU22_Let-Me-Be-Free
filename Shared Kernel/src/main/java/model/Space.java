package model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class Space {
    private String id;
    private String name;
    private String location;
    private int capacity;
    private String address;
    private List<String> equipments;
    private String participants;
    private List<LocalDate> availabilities;
    private Recruiter owner;
    private Map<String, Object> info;
}
