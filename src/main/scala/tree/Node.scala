package tree

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
/*sealed trait Tree

case class Node(data: Int, children: Seq[Tree]) extends Tree

case class Leaf(data: Int) extends Tree*/

class Tree(val data: String) {
  var children: ListBuffer[Tree] = new ListBuffer[Tree]()

  def addChildren(c: Tree*): Tree = {
      c.foreach{ child =>
         this.children += child
      }
      this
  }

  def addNode(memberId: String, shardId: String, entityId: String): Unit = {
    var member: Tree = findNode(memberId)
    if(member == null) {
      member = Tree(memberId)
      children += member
    }

    var shard : Tree = findNode(shardId)
    if (shard == null) {
      shard = Tree(shardId)
      member.children += shard
    }

    var entity: Tree = findNode(entityId)
    if (entity == null) {
      entity = Tree(entityId)
      shard.children += entity
    }
  }
// find node by traversing every node
  def findNode(d: String): Tree = {
    if(d.isEmpty) {
      null
    }
    else {
      if(this.data == d) this
      for(c <- this.children) {
        val found = c.findNode(d)
        if (found != null) found
      }
    }
    null
  }
 // Tree traversal
  def printTree(node: Tree): Unit = {
    if (node == null) null
    val queue = mutable.Queue[Tree]()
    queue.enqueue(node)
    while(queue.nonEmpty) {
      var n = queue.size
      while(n > 0) {
        val p = queue.dequeue()
        print(p.data + " ")
        for(c <- p.children){
          queue.enqueue(c)
        }
        n = n - 1
      }
      println()
    }
  }
}

object Tree {
  def apply(data: String): Tree = {
    new Tree(data)
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val tree = Tree("cluster")
    tree.addNode("member1", "shard01", "entity01")
    tree.addNode("member1", "shard01", "entity02")
    tree.addNode("member1", "shard01", "entity03")
    tree.addNode("member1", "shard02", "entity01")
    tree.addNode("member1", "shard02", "entity02")

    tree.addNode("member2", "shard01", "entity01")

    tree.printTree(tree)
  }
}