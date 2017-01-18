package main

import (
    "testing"
    "container/list"
    "fmt"
    )

func TestSample(t *testing.T) {

    //   1--- 0 smallest cover : { 0 , 3} size : 2
    //      / \
    //     2   3---4



    graph := make(map[int]*list.List)
    e := list.Element{Value:1}
    fmt.Println(e)
    graph[0] = list.New()
    graph[1] = list.New()
    graph[2] = list.New()
    graph[3] = list.New()
    graph[4] = list.New()

    graph[0].PushBack(1)
    //graph[1].PushBack(0)

    graph[0].PushBack(2)
    graph[2].PushBack(0)

    graph[0].PushBack(3)
    graph[3].PushBack(0)

    graph[3].PushBack(4)
    graph[4].PushBack(3)

    vertex_cover(graph,2)


}
