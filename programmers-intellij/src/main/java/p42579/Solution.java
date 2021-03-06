package p42579;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Genre> map = new HashMap<>();
        Queue<Genre> queue = new PriorityQueue<>(Collections.reverseOrder());

        init(queue, genres, plays, map);

        while(!queue.isEmpty()){
            List<Song> songs = queue.poll().getSongs();
            Collections.sort(songs);
            int index = 0;
            while(!songs.isEmpty() && index < 2) {
                answer.add(songs.remove(0).getId());
                index++;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void init(Queue<Genre> queue, String[] genres, int[] plays, Map<String, Genre> map) {
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Genre aGenre = map.getOrDefault(genre, new Genre(0, new ArrayList<>()));
            aGenre.add(new Song(i, plays[i]));
            map.put(genre, aGenre);
        }

        for (String s : map.keySet()) {
            queue.offer(map.get(s));
        }
    }
}

class Genre implements Comparable<Genre> {
    private int sumOfPlay;
    private List<Song> songs;

    public Genre(int sumOfPlay, List<Song> songs) {
        this.sumOfPlay = sumOfPlay;
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void add(Song song) {
        this.sumOfPlay += song.getPlay();
        this.songs.add(song);
    }

    @Override
    public int compareTo(Genre o) {
        return this.sumOfPlay - o.sumOfPlay;
    }
}

class Song implements Comparable<Song> {
    private int id;
    private int play;

    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }

    public int getId() {
        return id;
    }

    public int getPlay() {
        return play;
    }

    @Override
    public int compareTo(Song o) {
        if(o.play - this.play == 0) {
            return this.id - o.id;
        }
        return o.play - this.play;
    }
}