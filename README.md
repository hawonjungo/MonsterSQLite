# MonstersRecyclerViewWithSQLite0-start
Starter Project for Monsters Recycler View

## Why a Recycler View?
### When the user scrolls, visible items which became out of view will be recycled and reused when a new item comes into view.
### We use RecyclerView for a simple reason: your phone have a limited amount of memory. Consequently, if you create for each contact an item, you will use a lot of memory.
![RecyclerView-recyclingViews](https://user-images.githubusercontent.com/4823319/81139933-e9538a80-8faa-11ea-8ccb-6f2e903919b9.png)

## How it Works?
### When the RecyclerView is being laid out and drawn → it will ask the Adapter for the numbers of items that will be displayed.
![1_yxiFngNac4m9DLEM-aTd-A](https://user-images.githubusercontent.com/4823319/81140020-42bbb980-8fab-11ea-8392-8deac460ee63.png)

### Then, the RecyclerView will ask the Adapter to create ViewHolder objects. And the process, inflate individually item views from their corresponding XML by calling onCreateViewHolder.
![1_OB895Pqa7AQkPLSScRfsYQ](https://user-images.githubusercontent.com/4823319/81140197-df7e5700-8fab-11ea-9488-4dfbce3fcfae.png)

### After each ViewHolder is created, the RecyclerView will call onBindViewHolder to populate each item with data.
![1_2GWv-hL1os5YYBkVi8lpGA](https://user-images.githubusercontent.com/4823319/81140243-0c326e80-8fac-11ea-8a5d-5afbb29c1a42.png)
### Then, when you scroll the RecyclerView will reuse those ViewHolders asking the Adapter to bind new data to them.


## Recycler View used in this app
![untitled_page](https://user-images.githubusercontent.com/4823319/81139722-1ce1e500-8faa-11ea-8eaa-253b95928207.png)


## Layout Managers
<img width="705" alt="Screen Shot 2020-05-06 at 1 03 58 pm" src="https://user-images.githubusercontent.com/4823319/81139821-84983000-8faa-11ea-8100-65a3588d593d.png">


