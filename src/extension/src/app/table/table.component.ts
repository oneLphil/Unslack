import { Component, OnInit, OnChanges, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit, OnChanges {
  @Input() columns: any[];
  displayedColumns: any[];
  @Input() dataSource: any[];
  displayedDataSource: any;

  /*columns = [
    { columnDef: 'position', header: 'No.',    cell: (element: Element) => `${element.position}` },
    { columnDef: 'name',     header: 'Name',   cell: (element: Element) => `${element.name}`     },
    { columnDef: 'weight',   header: 'Weight', cell: (element: Element) => `${element.weight}`   },
    { columnDef: 'symbol',   header: 'Symbol', cell: (element: Element) => `${element.symbol}`   },
  ];*/

  /* Example for Room
  export class Room {
      id: number;
      name: string;
      member_ids: number[];
      blacklist: string[];
      scores: number[];
  }
  columns = [
    { columnDef: 'id', header: 'ID',    cell: (room: Room) => `${room.id}` },
    { columnDef: 'name',     header: 'Name',   cell: (room: Room) => `${room.name}`     },
    { columnDef: 'member_ids',   header: 'Members', cell: (room: Room) => `${room.member_ids}`   },
    { columnDef: 'blacklist',   header: 'Blacklist', cell: (room: Room) => `${room.blacklist}`   },
    { columnDef: 'scores',   header: 'Scores', cell: (room: Room) => `${room.scores}`   },
  ];
  */
  constructor() { }

  updateTable() {
    this.displayedColumns = this.columns.map(x => x.columnDef);
    this.displayedDataSource = new MatTableDataSource(this.dataSource);
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.displayedDataSource.filter = filterValue;
  }

  ngOnInit() {
  }

  ngOnChanges() {
    this.updateTable();

  }
}
