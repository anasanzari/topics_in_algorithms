package main

import (
    "fmt"
    "container/list"
)

func main(){

    fmt.Printf("Parameterized Vertex Cover\n")
    fmt.Printf("Enter n:")
    var n int
    fmt.Scanf("%d\n", &n)

    //make Graph using map.
    var graph map[int]*list.List
    graph = make(map[int]*list.List)

    fmt.Printf("Enter edges:\n")

    for i := 0;  i < n; i++ {
        var a, b int
        fmt.Scanf("%d %d\n", &a, &b)
        //fmt.Printf("%d %d\n", a, b)
        l , ok := graph[a]
        if ok {
            l.PushBack(b)
        }else{
            graph[a] = list.New()
            graph[a].PushBack(b)
        }

        l, ok = graph[b]
        if ok {
            l.PushBack(a)
        }else{
            graph[b] = list.New()
            graph[b].PushBack(a)
        }
    }

    fmt.Printf("Enter the parameter k: ")
    var k int
    fmt.Scanf("%d\n", &k)

    vertex_cover(graph,k)



}

// depth bounded search
func vertex_cover(graph map[int]*list.List, k int){

    //reduction one  : Remove degree zero vertices
    count := 0
    for k,v := range graph {
        if v.Len() == 0 {
            fmt.Printf("Delete %d\n",k)
            delete(graph, k)
            count++
        }
    }

    //reduction two : Remove degree k+1 or more vertices

    for node,neighbours := range graph {
        if neighbours.Len() >= (k+1) {

            fmt.Printf("Delete %d\n",node)

            for e := neighbours.Front(); e != nil; e = e.Next() {

                v := e.Value.(int) // need to master casting
                //graph[v].Remove(node)
                fmt.Println(v)
            }
            delete(graph, node)
            count++
        }
    }




    fmt.Println(graph)

}
