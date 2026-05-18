class Twitter {
    private var time = 0
    private val tweets = HashMap<Int, MutableList<Pair<Int, Int>>>()
    private val followers = HashMap<Int, MutableSet<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        val userTweets = tweets.getOrDefault(userId, mutableListOf())
        userTweets.add(Pair(time, tweetId))
        tweets[userId] = userTweets
        time++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feed = mutableSetOf<Pair<Int, Int>>()
        tweets[userId]?.let { feed.addAll(it) }
        followers[userId]?.let { followees ->
            followees.forEach { followeeId ->
                tweets[followeeId]?.let { feed.addAll(it) }
            }
        }
        
        return feed.sortedByDescending { it.first }
            .take(10)
            .map { it.second }
    }

    fun follow(followerId: Int, followeeId: Int) {
        val userFollowees = followers.getOrDefault(followerId, mutableSetOf())
        userFollowees.add(followeeId)
        followers[followerId] = userFollowees
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val userFollowees = followers.getOrDefault(followerId, mutableSetOf())
        userFollowees.remove(followeeId)
        followers[followerId] = userFollowees
    }
}
