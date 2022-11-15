import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;
import service.HistoryManager;
import service.InMemoryTaskManager;
import service.TaskManager;
import utility.UtilityManagers;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = UtilityManagers.getManager();

        Task task1 = taskManager.addTask(new Task("Тест1", "Добавляем первый тест", TaskStatus.NEW));

        Task task44 = new Task("Тест44", "Тест44", TaskStatus.IN_PROGRESS);

        Epic epic1 = taskManager.addEpic(new Epic("Эпик1", "Добавляем тест1 эпик"));
        Epic epic2 = taskManager.addEpic(new Epic("Эпик2", "Добавляем тест2 эпик"));
        System.out.println(task1);

        SubTask subTask1 = taskManager.addSubTask(new SubTask("subtask", "text subtask2", TaskStatus.NEW));
        SubTask subTask2 = taskManager.addSubTask(new SubTask("subtask", "text subtask2", TaskStatus.NEW));
        SubTask subTask3 = taskManager.addSubTask(new SubTask("subtask", "text subtask2", TaskStatus.NEW));

        epic1.getSubTaskList().add(subTask1);
        epic1.getSubTaskList().add(subTask2);

        epic2.getSubTaskList().add(subTask3);

        subTask1.setEpic(epic1);
        subTask2.setEpic(epic2);

        Task task3 = taskManager.addTask(new Task("Тест23", "Тест апдейта 1", TaskStatus.NEW));

        task3.setName("raz");

        taskManager.updateTask(task3);
        System.out.println(task3);
        taskManager.updateTask(task44);
        Task task2 = taskManager.addTask(new Task("Тест2", "Добавляем второй тест", TaskStatus.NEW));
        System.out.println(task2);
        }
}