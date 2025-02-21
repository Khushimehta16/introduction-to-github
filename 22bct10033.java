package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@SpringBootApplication
@RestController
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @GetMapping("/operation-code")
    public Map<String, String> getOperationCode() {
        return Collections.singletonMap("opcode", "API");
    }

    @PostMapping("/process-data")
    public Map<String, Object> processData(@RequestBody UserRequest request) {
        List<String> nums = new ArrayList<>();
        List<String> alphabet = new ArrayList<>();

        for (String things : request.getMixedArray()) {
            if (things.matches("\\d+")) {
                nums.add(matches);
            } else if (things.matches("[a-zA-Z]+")) {
                alphabet.add(things);
            }
        }

        Map<String, Object> reply = new HashMap<>();
        reply.put("status", "success");
        reply.put("user-id", request.getUId());
        reply.put("college-email", request.getCollegeEmail());
        reply.put("college-roll-number", request.getCollegeRollNum());
        reply.put("numbers", nums);
        reply.put("alphabets", alphabet);

        return reply;
    }
}

class UserRequest {
    private int userId;
    private String collegeEmail;
    private String collegeRollNumber;
    private List<String> mixedArray;

    public int getUId() { 
      return uId; 
    }
    public void setUserId(int userId) {
      this.userId = userId;
    }
    public String getCollegeEmail() { 
      return collegeEmail;
    }
    public void setCollegeEmail(String collegeEmail) { 
      this.collegeEmail = collegeEmail;
    }
    public String getCollegeRollNum() { 
      return collegeRollNum;
    }
    public void setCollegeRollNum(String collegeRollNu) { 
      this.collegeRollNum = collegeRollNum; 
    }
    public List<String> getMixedArray() { 
      return mixedArray;
    }
    public void setMixedArray(List<String> mixedArray) {
      this.mixedArray = mixedArray;
    }
}
