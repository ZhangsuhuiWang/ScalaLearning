val colors1 = Set("Blue", "Red", "Green")
println(s"colors1: $colors1")

val colors2 = colors1 + "Black"
println(s"colors2: $colors2")
println(s"colors1: $colors1")

val feeds1 = Set("blog.toolshed.com", "pragdave.me", "blog.agiledeveloper.com")
val feeds2 = Set("blog.toolshed.com", "martinfowler.com/bliki")

val blogFeeds = feeds1 filter(_ contains "blog")
println(s"blog feeds: ${blogFeeds.mkString(", ")}")

val mergedFeeds = feeds1 ++ feeds2
println(s"# of merged feeds: ${mergedFeeds.size}")

val commonFeeds = feeds1 & feeds2
println(s"# of common feeds: ${commonFeeds.mkString(", ")}")

val url = feeds1.map("https://"+_)
println(s"One url: ${url.head}")

println("Refreshing Feeds:")
feeds1 foreach(feed => println(s" Refreshing $feed..."))

val feeds = Map(
  "Andy Hunt" -> "blog.toolshed.com",
  "Dave Thoms" -> "pragdave.com",
  "NFJS" -> "nofluffjuststuff.com/blog"
)

val filterNameStartWithD = feeds filterKeys(_ startsWith "D")
println(s"# of Filtered: ${filterNameStartWithD.size}")

val filterNameStartWithAndPrgprogInFeed = feeds filter {element =>
  val(key, value) = element
  (key startsWith "D") && (value contains "pragdave")
}
println("# of feeds with auth name D* and pragdave in URL: ")
println(filterNameStartWithAndPrgprogInFeed.size)

println(s"Get Andy's Feed: ${feeds.get("Andy Hunt")}")
println(s"Get Dave's Feed: ${feeds.get("Dave Thoms")}")
println("******************************")

try {
  println(s"Get Andy's Feed Using apply(): ${feeds("Andy Hunt")}")
  print("Get Bill's Feed: ")
  println(feeds("Bill Who"))
} catch {
  case _: java.util.NoSuchElementException => println("Not Found")
}

val newFeeds1 = feeds.updated("Venkat Subramaniam", "blog.agiledeveloper.com")
println("Venkat's blog in original feed: " + feeds.get("Venkat Subramaniam"))
println("Venkat's blog in new feed: " + newFeeds1("Venkat Subramaniam"))

val feed = List("blog.toolshed.com", "pragdave.me", "blog.agiledeveloper.com")
println(s"First feed: ${feed.head}")
println(s"Second feed: ${feed(1)}")

val prefixedList = "forums.pragprog.com/formus/87" :: feed
println(s"First Feed in Prefixed: ${prefixedList.head}")

val feedWithForums =
  feed ::: List(
    "forums.pragprog.com/forums/87",
    "forums.pragprog.com/forums/246"
  )
println(s"First Feed in feed with forum: ${feedWithForums.head}")
println(s"Last Feed in feed withf forum: ${feedWithForums.last}")

println(s"Feed with blog: ${feed.filter(_ contains "blog").mkString(", ")}")
println(s"All Feed have com: ${feed.forall(_ contains "com")}")
println(s"All feed have dave: ${feed.forall(_ contains "dave")}")
println(s"Any feed have dave: ${feed.exists(_ contains "dave")}")
println(s"Any feed have bill: ${feed.exists(_ contains "bill")}")

println(s"Feed url lengths: ${feed.map(_.length).mkString(", ")}")

//val total = feed.foldLeft(0){(total, feed) => total + feed.length}
val total = (0 /: feed)(_ + _.length)
println(s"Total length of feed urls: $total")
















