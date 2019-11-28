package bodyApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bodyApp.entities.CoachCertification;

public interface iCoachCertification extends JpaRepository<CoachCertification, Long> {

}
