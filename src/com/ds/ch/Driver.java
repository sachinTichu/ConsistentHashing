package com.ds.ch;

public class Driver
{

    public static void main(String args[]){
        PhysicalNode node1 = new PhysicalNode("host1","127.0.0.1",8080);
        PhysicalNode node2 = new PhysicalNode("host2","127.0.0.1",8081);
        PhysicalNode node3 = new PhysicalNode("host3","127.0.0.1",8082);
        PhysicalNode node4 = new PhysicalNode("host4","127.0.0.1",8083);

        HashingFunction hashFun = new HashAlgorithm();

        ConsistentHashingRouter<PhysicalNode> router = new ConsistentHashingRouter<PhysicalNode>(hashFun,4);

        router.addNode(node1);
        router.addNode(node2);
        router.addNode(node3);
        router.addNode(node4);

        String ip1 = "198.0.0.1";
        String ip2 = "198.0.0.10";
        String ip3 = "188.255.256.0";
        String ip4 = "10.152.190.256";
        String ip5 = "10.152.190.253";
        String ip6 = "10.11.13.2";

        System.out.println("Routing Before Adding Node will be ::");

        System.out.println("Route to ip1 is :: "+router.getRoute(ip1));
        System.out.println("Route to ip2 is :: "+router.getRoute(ip2));
        System.out.println("Route to ip3 is :: "+router.getRoute(ip3));
        System.out.println("Route to ip4 is :: "+router.getRoute(ip4));
        System.out.println("Route to ip5 is :: "+router.getRoute(ip5));
        System.out.println("Route to i6 is :: " + router.getRoute(ip6));

        PhysicalNode node5 = new PhysicalNode("host5","127.0.0.1",8084);

        router.addNode(node5);

        System.out.println("Routing After Adding Node will be ::");
        System.out.println("Route to ip1 is :: "+router.getRoute(ip1));
        System.out.println("Route to ip2 is :: "+router.getRoute(ip2));
        System.out.println("Route to ip3 is :: "+router.getRoute(ip3));
        System.out.println("Route to ip4 is :: "+router.getRoute(ip4));
        System.out.println("Route to ip5 is :: "+router.getRoute(ip5));
        System.out.println("Route to i6 is :: " + router.getRoute(ip6));

        router.removeNode(node1);

        System.out.println("Routing After Removing Node will be ::");
        System.out.println("Route to ip1 is :: "+ router.getRoute(ip1));
        System.out.println("Route to ip2 is :: "+ router.getRoute(ip2));
        System.out.println("Route to ip3 is :: "+ router.getRoute(ip3));
        System.out.println("Route to ip4 is :: "+ router.getRoute(ip4));
        System.out.println("Route to ip5 is :: "+ router.getRoute(ip5));
        System.out.println("Route to ip6 is :: "+ router.getRoute(ip6));
    }
}
