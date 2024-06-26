package PlayList;

public class Song {
    private final String title;  // 곡 제목
    private final String artist; // 아티스트
    private final String album;  // 앨범
    private final int duration;  // 재생 시간 (초 단위)

    // 생성자
    public Song(final String title, final String artist, final String album, final int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    // Getter 메서드들
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    // 곡 정보를 문자열로 반환
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                '}';
    }
}
