package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");
    }

}


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName); // Tìm kiếm User bởi tên đầu tiên
    List<User> findByLastName(String lastName); // Tìm kiếm User bởi tên cuối
    List<User> findByAgeGreaterThan(int age); // Tìm kiếm User có tuổi lớn hơn
    List<User> findByFirstNameAndLastName(String firstName, String lastName); // Tìm kiếm User bởi tên đầu tiên và tên cuối
    List<User> findByAgeBetween(int start, int end); // Tìm kiếm User có tuổi trong khoảng
    List<User> findByFirstNameLike(String name); // Tìm kiếm User bởi tên đầu tiên tương đồng
    List<User> findByLastNameIsNotNull(); // Tìm kiếm User có tên cuối khác null
    List<User> findByIdIn(List<Long> ids); // Tìm kiếm User bởi danh sách id
    List<User> findByFirstNameOrLastName(String firstName, String lastName); // Tìm kiếm User bởi tên đầu tiên hoặc tên cuối
    List<User> findByAgeGreaterThanOrderByLastNameDesc(int age); // Tìm kiếm User có tuổi lớn hơn và sắp xếp theo tên cuối giảm dần
}