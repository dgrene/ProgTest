package week8

import scala.collection.mutable.HashSet

object AddressCache {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val addcache = new AddressCache(10, "123344")   //> addcache  : week8.AddressCache = week8.AddressCache@60f82f98

  addcache.add(new Address("google.com"))         //> res0: scala.collection.mutable.LinkedHashSet[week8.Address] = Set(Address(go
                                                  //| ogle.com))

  addcache.add(new Address("yahoo.com"))          //> res1: scala.collection.mutable.LinkedHashSet[week8.Address] = Set(Address(go
                                                  //| ogle.com), Address(yahoo.com))

  addcache.add(new Address("webcat.com"))         //> res2: scala.collection.mutable.LinkedHashSet[week8.Address] = Set(Address(go
                                                  //| ogle.com), Address(yahoo.com), Address(webcat.com))

  addcache.add(new Address("webcat1.com"))        //> res3: scala.collection.mutable.LinkedHashSet[week8.Address] = Set(Address(go
                                                  //| ogle.com), Address(yahoo.com), Address(webcat.com), Address(webcat1.com))

  //addcache.add(new Address("webcat2.com"))
  //addcache.add(new Address("webcat3.com"))
  //addcache.add(new Address("webcat4.com"))

  addcache.remove(Address("webcat.com"))

  addcache.peek                                   //> res4: week8.Address = Address(webcat1.com)

  addcache.take                                   //> res5: week8.Address = Address(webcat1.com)

}

case class Address(url: String)

class AddressCache(maxAge: Long, TimeUnit: String) {

  var l = scala.collection.mutable.LinkedHashSet[Address]()

  def add(InetAddress: Address) = {
    l += InetAddress
    //s.push(InetAddress)
  }

  def remove(InetAddres: Address) {
    l -= InetAddres
  }

  def peek() = {
    l.lastOption.getOrElse(null)
  }

  def take() = {
    l.lastOption match {
      case None => null
      case x: Option[Address] => {
        l -= l.last
        x.get
      }
    }
  }

}