def mad(num: Int): Int = {
  if(num == 0)
    throw new RuntimeException("Error")
  else
    1 * mad(num - 1)
}

mad(5)
