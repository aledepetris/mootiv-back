import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import com.mootiv.domain.goal.ScheduleGoal;
import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.domain.plan.TrainingPlan;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrainingPlanTest {

    @Test
    void testCreateNewCycle_ValidCycle() {
        TrainingPlan plan = new TrainingPlan();
        var goal = createGoal();
        var type = createTrainingType();
        assertDoesNotThrow(() -> plan.createNewCycle(LocalDate.now(), 4, 2, goal, type));
    }

    @Test
    void testCreateNewCycle_inValidCycleBecauseScheduleGoal() {
        TrainingPlan plan = new TrainingPlan();
        var goal = createGoal();
        var type = createTrainingType();
        assertThrows(RuntimeException.class ,() -> plan.createNewCycle(LocalDate.now(), 4, 3, goal, type));
    }


    @Test
    void testCreateNewCycle_StartDateInPast() {
        TrainingPlan plan = new TrainingPlan();
        Goal goal = new Goal();
        TrainingType type = new TrainingType();

        assertThrows(IllegalArgumentException.class, () ->
                plan.createNewCycle(LocalDate.now().minusDays(1), 4, 3, goal, type));
    }

    @Test
    void testCreateNewCycle_OverlapWithExisting() {
        TrainingPlan plan = new TrainingPlan();
        var goal = createGoal();
        var type = createTrainingType();

        //First cycle
       plan.createNewCycle(LocalDate.now(), 4, 2, goal, type);
        // Try to create an overlap cycly



        assertThrows(IllegalStateException.class, () ->
                plan.createNewCycle(LocalDate.now(), 4, 2, goal, type));
    }

    @Test
    void testDeleteCycleById_CycleNotFound() {
        TrainingPlan plan = new TrainingPlan();
        assertThrows(RuntimeException.class, () -> plan.deleteCycleById(999));
    }

    @Test
    void testDeleteCycleById_CannotBeDeleted() {
        var plan = createPlanForCannotDeleteCycle();
        assertThrows(RuntimeException.class, () -> plan.deleteCycleById(1));
    }

    @Test
    void testDeleteCycleById_Deleted() {
        var plan = createPlanForDeleteCycle();
        assertDoesNotThrow(() -> plan.deleteCycleById(1));
    }

    private TrainingType createTrainingType() {
        TrainingType type = new TrainingType();
        type.setId(1);
        type.setName("Prueba");
        return type;
    }

    private Goal createGoal() {
        Goal goal = new Goal();
        var sc1 = new ScheduleGoal();
        sc1.setDayOfTraining(2);
        sc1.setTrainingTypes(Set.of(createTrainingType()));
        goal.setScheduleGoals(Set.of(sc1));
        return goal;
    }

    private TrainingPlan createPlanForDeleteCycle() {
        TrainingPlan plan = new TrainingPlan();
        Goal goal = createGoal();
        var type = createTrainingType();

        plan.createNewCycle(LocalDate.now().plusDays(1), 4, 2, goal, type);
        plan.getTrainingCycles().get(0).setId(1);
        return plan;
    }

    private TrainingPlan createPlanForCannotDeleteCycle() {
        TrainingPlan plan = new TrainingPlan();
        Goal goal = createGoal();
        var type = createTrainingType();

        plan.createNewCycle(LocalDate.now().plusDays(1), 4, 2, goal, type);
        plan.getTrainingCycles().get(0).setId(1);
        plan.getTrainingCycles().get(0).setStatus(CycleStatus.COMPLETADO);

        return plan;
    }

}
