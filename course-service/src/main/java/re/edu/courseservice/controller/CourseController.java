package re.edu.courseservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/api/courses")
    public String getCourses(
            @RequestHeader("X-User-Role") String role
    ) {
        return "Course Service is running! User Role: " + role;
    }
}
