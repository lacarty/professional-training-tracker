package org.launchcode.professionaltrainingtracker.models.data;

import org.launchcode.professionaltrainingtracker.models.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TrainingDao extends CrudRepository<Training, Integer> {

}
