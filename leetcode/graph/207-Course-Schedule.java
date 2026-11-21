class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // questions is basically asking can u topologically sort the courses
        // it not , then it means it's not possible to complete all courses

        List<Integer> topo = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[numCourses]; //given : numCourses courses you have to take, labeled from 0 to numCourses - 1
        List<List<Integer>> adj = new ArrayList<>(); // adjacency list
        for(int i = 0 ; i < numCourses ; i++) adj.add(new ArrayList<>());

        for(int[] a : prerequisites){
            adj.get(a[0]).add(a[1]);
            indegree[a[1]]++;
        }
        for(int i = 0 ; i < numCourses ; i++) if(indegree[i] == 0) q.addFirst(i);

        while(!q.isEmpty()){
            int node = q.getLast();
            topo.add(q.removeLast());
            
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n] == 0) q.addFirst(n);
            }
        }
        if(topo.size() == numCourses) return true;
        return false;
    }
}