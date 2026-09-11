class Solution {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        // Sort by timestamp.
        // If timestamps are equal, OFFLINE comes before MESSAGE.
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));

            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }

            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        for (List<String> event : events) {

            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String data = event.get(2);

            if (type.equals("OFFLINE")) {

                int user = Integer.parseInt(data);

                // User is offline for 60 seconds
                offlineUntil[user] = time + 60;

            } else {

                if (data.equals("ALL")) {

                    // Mention everyone
                    for (int user = 0; user < numberOfUsers; user++) {
                        mentions[user]++;
                    }

                } else if (data.equals("HERE")) {

                    // Mention only currently online users
                    for (int user = 0; user < numberOfUsers; user++) {

                        if (offlineUntil[user] <= time) {
                            mentions[user]++;
                        }
                    }

                } else {

                    // Explicit user IDs
                    String[] users = data.split(" ");

                    for (String user : users) {
                        int id = Integer.parseInt(user.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }

        return mentions;
    }
}