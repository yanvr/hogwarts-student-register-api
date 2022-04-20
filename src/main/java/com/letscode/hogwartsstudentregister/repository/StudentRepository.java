package com.letscode.hogwartsstudentregister.repository;

import com.letscode.hogwartsstudentregister.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
