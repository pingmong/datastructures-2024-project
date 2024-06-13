package PlayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicPlaylist myPlaylist = new MusicPlaylist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 사용자에게 선택지 제공
            System.out.println("1. 곡 추가");
            System.out.println("2. 곡 삭제");
            System.out.println("3. 플레이리스트 표시");
            System.out.println("4. 제목별 정렬된 플레이리스트 표시");
            System.out.println("5. 아티스트별 정렬된 플레이리스트 표시");
            System.out.println("6. 제목으로 곡 검색");
            System.out.println("7. 아티스트로 곡 검색");
            System.out.println("8. 총 재생 시간 계산");
            System.out.println("9. 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            switch (choice) {
                case 1:
                    // 곡 추가
                    System.out.print("곡 제목을 입력하세요: ");
                    String title = scanner.nextLine();
                    System.out.print("아티스트를 입력하세요: ");
                    String artist = scanner.nextLine();
                    System.out.print("앨범을 입력하세요: ");
                    String album = scanner.nextLine();
                    System.out.print("재생 시간을 초 단위로 입력하세요: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 소비
                    myPlaylist.addSong(new Song(title, artist, album, duration));
                    break;
                case 2:
                    // 곡 삭제
                    System.out.print("삭제할 곡의 제목을 입력하세요: ");
                    String titleToRemove = scanner.nextLine();
                    myPlaylist.removeSong(titleToRemove);
                    break;
                case 3:
                    // 플레이리스트 표시
                    myPlaylist.playlist();
                    break;
                case 4:
                    // 제목별 정렬된 플레이리스트 표시
                    myPlaylist.playlistByTitle();
                    break;
                case 5:
                    // 아티스트별 정렬된 플레이리스트 표시
                    myPlaylist.playlistByArtist();
                    break;
                case 6:
                    // 제목으로 곡 검색
                    System.out.print("검색할 곡의 제목을 입력하세요: ");
                    String searchTitle = scanner.nextLine();
                    Song song = myPlaylist.searchByTitle(searchTitle);
                    if (song != null) {
                        System.out.print("찾았습니다: " + song);
                    } else {
                        System.out.print("곡을 찾을 수 없습니다.");
                    }
                    break;
                case 7:
                    // 아티스트로 곡 검색
                    System.out.print("검색할 아티스트를 입력하세요: ");
                    String searchArtist = scanner.nextLine();
                    var songs = myPlaylist.searchByArtist(searchArtist);
                    if (!songs.isEmpty()) {
                        for (Song s : songs) {
                            System.out.println("찾았습니다: " + s);
                        }
                    } else {
                        System.out.println("해당 아티스트의 곡을 찾을 수 없습니다.");
                    }
                    break;
                case 8:
                    // 총 재생 시간 계산
                    int totalDuration = myPlaylist.getTotalDuration();
                    System.out.println("총 재생 시간: " + totalDuration + "초");
                    break;
                case 9:
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    // 잘못된 입력 처리
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}
