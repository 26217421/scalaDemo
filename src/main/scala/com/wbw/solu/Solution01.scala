package com.wbw.solu

object Solution01 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.zipWithIndex
    map.filter(elem=> map.exists(x => x._1 == target - elem._1 && x._2 != elem._2)).map(_._2)
  }
}
