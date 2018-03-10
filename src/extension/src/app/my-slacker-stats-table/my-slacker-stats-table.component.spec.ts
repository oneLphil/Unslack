import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MySlackerStatsTableComponent } from './my-slacker-stats-table.component';

describe('MySlackerStatsTableComponent', () => {
  let component: MySlackerStatsTableComponent;
  let fixture: ComponentFixture<MySlackerStatsTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MySlackerStatsTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MySlackerStatsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
