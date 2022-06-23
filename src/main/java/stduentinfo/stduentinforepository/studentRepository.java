package stduentinfo.stduentinforepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stduentinfo.stduentinfoentity.student;
@Repository
public interface studentRepository extends JpaRepository<student, Integer> {

}
