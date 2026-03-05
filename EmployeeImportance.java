
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0 ;
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        q.add(map.get(id));

        while(!q.isEmpty()) {
            Employee curr = q.poll();
            total = curr.importance + total;
            for (int sub:curr.subordinates) {
                q.add(map.get(sub));
            }
        }
        return total;
    }
}