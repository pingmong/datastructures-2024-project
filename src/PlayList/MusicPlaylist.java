package PlayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Comparator;

public class MusicPlaylist {
    private HashMap<String, Song> playlist;  // 곡 제목을 키로 사용하여 곡 정보를 저장하는 HashMap
    private TreeSet<Song> sortedByTitle;     // 곡 제목으로 정렬 TreeSet
    private TreeSet<Song> sortedByArtist;    // 아티스트로 정렬 TreeSet
    private Song[] songArray;                // 곡들을 저장할 배열
    private int currentIndex;                // 배열에 곡을 추가할 현재 인덱스

    // 생성자
    public MusicPlaylist(Song[] initialSongs) {
        playlist = new HashMap<>();
        // 내부적으로 전달 받은 Function으로 값을 추출하여 비교하는 Comparator를 반환
        sortedByTitle = new TreeSet<>(Comparator.comparing(Song::getTitle));
        sortedByArtist = new TreeSet<>(Comparator.comparing(Song::getArtist));
        songArray = initialSongs;

        for (Song song : initialSongs) { //초기 곡 데이터 배열(initialSongs)에 있는 곡들을 HashMap과 TreeSet에 추가
            if (song != null) {
                playlist.put(song.getTitle(), song);
                sortedByTitle.add(song);
                sortedByArtist.add(song);
            }
        }
    }

    // 곡을 플레이리스트에 추가 (중복 방지)
    public void addSong(Song song) {
        if (!playlist.containsKey(song.getTitle())) { // containsKey - 특정 key가 Map에 존재하는지 체크
            playlist.put(song.getTitle(), song);
            sortedByTitle.add(song);
            sortedByArtist.add(song);
            // 배열 추가 구현 부분
            if (currentIndex < songArray.length) {
                songArray[currentIndex++] = song;
            } else {
                System.out.println("재생 목록이 가득 찼습니다. 곡을 추가할 수 없습니다.");
            }
        } else {
            System.out.println("재생 목록에 노래가 이미 존재합니다.");
        }
    }

    // 제목으로 곡을 플레이리스트에서 제거
    public void removeSong(String title) {
        Song song = playlist.remove(title);
        if (song != null) {
            sortedByTitle.remove(song);
            sortedByArtist.remove(song);
            // 배열 추가 구현 부분
            for (int i = 0; i < currentIndex; i++) {
                if (songArray[i] != null && songArray[i].getTitle().equals(title)) {
                    songArray[i] = null;
                    break;
                }
            }
        }
    }

    // 플레이리스트의 모든 곡을 출력
    public void playlist() {
        for (Song song : playlist.values()) {
            System.out.println(song);
        }
    }

    // 곡 제목을 기준으로 플레이리스트 출력
    public void playlistByTitle() {
        for (Song song : sortedByTitle) {
            System.out.println(song);
        }
    }

    // 아티스트를 기준으로 플레이리스트 출력
    public void playlistByArtist() {
        for (Song song : sortedByArtist) {
            System.out.println(song);
        }
    }

    // 배열에 저장된 곡들을 출력
    public void displaySongArray() {
        for (Song song : songArray) {
            if (song != null) {
                System.out.println(song);
            }
        }
    }

    // 제목으로 곡을 검색
    public Song searchByTitle(String title) {
        return playlist.get(title);
    }

    // 아티스트로 곡을 검색
    public ArrayList<Song> searchByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : playlist.values()) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                // equalsIgnoreCase - 대소문자를 구분하지 않고 비교, equals - 대소문자를 구분하여 비교
                result.add(song);
            }
        }
        return result;
    }

    // 총 재생 시간 계산
    public int getTotalDuration() {
        int totalDuration = 0;
        for (Song song : playlist.values()) {
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }
}

