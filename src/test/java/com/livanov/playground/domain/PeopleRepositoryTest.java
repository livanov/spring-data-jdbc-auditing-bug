package com.livanov.playground.domain;

import com.livanov.playground.TestPlaygroundApplication;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestPlaygroundApplication.ContainerConfiguration.class)
class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository repository;

    @Test
    void will_populate_auditing() {

        // GIVEN
        val stubbedPerson = new Person("George");
        stubbedPerson.setAddress("London");
        stubbedPerson.addEducation("Primary");
        stubbedPerson.addEducation("Secondary");
        val persistedPerson = repository.save(stubbedPerson);

        // WHEN
        val actual = repository.findById(persistedPerson.getId());

        // THEN
        assertThat(actual).hasValueSatisfying(person -> {
            assertThat(person.getCreatedAt()).describedAs("Person should have created time populated")
                    .isNotNull();
            assertThat(person.getAddress()).describedAs("Address should have created time populated")
                    .satisfies(address -> assertThat(address.getCreatedAt()).isNotNull());
            assertThat(person.getEducations()).describedAs("Educations should have created time populated")
                    .allSatisfy(education -> assertThat(education.getCreatedAt()).isNotNull());
        });
    }
}