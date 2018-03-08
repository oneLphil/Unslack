import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashtableComponent } from './dashtable.component';

describe('DashtableComponent', () => {
  let component: DashtableComponent;
  let fixture: ComponentFixture<DashtableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashtableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
