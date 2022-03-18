package duke;

import java.util.ArrayList;

/**
 * Handles the current list of Tasks while Duke is running
 */
public class TaskList {
    private final String LIST_INIT = "Here are the task:\n";
    private ArrayList<Task> masterList;

    public TaskList(ArrayList<Task> list) {
        this.masterList = list;
    }

    public TaskList() {
        this.masterList = new ArrayList<>();
    }

    public int size() {
        return this.masterList.size();
    }

    public Task get(int index) {
        return this.masterList.get(index);
    }

    public void addTask(Task task) {
        masterList.add(task);
    }

    /**
     * Shows the list of existing tasks
     *
     * @return String of list of tasks
     */
    public String list() {
        String toPrint = LIST_INIT;
        for (int i = 0; i < masterList.size(); i++) {
            Task currTask = masterList.get(i);
            toPrint += "\t" + (i + 1) + ". " + currTask + "\n";
        }
        return toPrint;
    }

    /**
     * Mark a task as done
     *
     * @param index Index of task in masterList
     * @return Task marked as done
     */
    public Task mark(int index) {
        Task currTask = masterList.get(index);
        currTask.markAsDone();
        masterList.set(index, currTask);
        return currTask;
    }

    /**
     * Mark a task as undone
     *
     * @param index Index of task in masterList
     * @return Task marked as undone
     */
    public Task unmark(int index) {
        Task currTask = masterList.get(index);
        currTask.unmarkItem();
        masterList.set(index, currTask);
        return currTask;
    }

    /**
     * Delete a task
     *
     * @param index Index of task in masterList
     * @return Deleted task
     */
    public Task delete(int index) {
        Task currTask = masterList.get(index);
        masterList.remove(index);
        return currTask;
    }

    /**
     * Find all tasks matching keyword
     * @param keyword Word to be searched
     * @return List of tasks that matches the keyword
     */
    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> listToReturn = new ArrayList<>();
        for (Task task: masterList) {
            if (task.description.contains(keyword)) {
                listToReturn.add(task);
            }
        }
        return listToReturn;
    }
}
